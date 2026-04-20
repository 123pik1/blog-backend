#!/bin/bash

# Konfiguracja
BASE_URL="http://localhost:8080/api"
USERNAME="dev_user"
PASSWORD="SafePassword123!"

echo "--- 1. Logowanie ---"
LOGIN_RESPONSE=$(curl -s -X POST "$BASE_URL/auth/login" \
    -H "Content-Type: application/json" \
    -d "{\"username\": \"$USERNAME\", \"password\": \"$PASSWORD\"}")

TOKEN=$(echo $LOGIN_RESPONSE | sed -n 's/.*"token":"\([^"]*\)".*/\1/p')

if [ -z "$TOKEN" ]; then
    echo "Błąd: Nie udało się pobrać tokena. Sprawdź hasło lub czy użytkownik istnieje."
    exit 1
fi
echo "Token pobrany pomyślnie."

echo -e "\n--- 2. Tworzenie Sekcji ---"
SECTION_RESPONSE=$(curl -s -X POST "$BASE_URL/sections" \
    -H "Authorization: Bearer $TOKEN" \
    -H "Content-Type: application/json" \
    -d '{
       "name": "Programowanie",
       "description": "Sekcja o tworzeniu oprogramowania"
     }')

# Wyciągamy ID sekcji
SECTION_ID=$(echo $SECTION_RESPONSE | sed -n 's/.*"id":\([0-9]*\).*/\1/p')

if [ -z "$SECTION_ID" ]; then
    echo "Błąd tworzenia sekcji. Odpowiedź: $SECTION_RESPONSE"
    exit 1
fi
echo "Utworzono sekcję o ID: $SECTION_ID"

echo -e "\n--- 3. Tworzenie Kategorii ---"
# Zwróć uwagę na pole sectionId - zmień je, jeśli Twoje CategoryDTO używa innej nazwy!
CATEGORY_RESPONSE=$(curl -s -X POST "$BASE_URL/categories" \
    -H "Authorization: Bearer $TOKEN" \
    -H "Content-Type: application/json" \
    -d "{
       \"name\": \"Java i Spring\",
       \"sectionId\": $SECTION_ID
     }")

# Wyciągamy ID kategorii
CATEGORY_ID=$(echo $CATEGORY_RESPONSE | sed -n 's/.*"id":\([0-9]*\).*/\1/p')

if [ -z "$CATEGORY_ID" ]; then
    echo "Błąd tworzenia kategorii. Odpowiedź: $CATEGORY_RESPONSE"
    exit 1
fi
echo "Utworzono kategorię o ID: $CATEGORY_ID"

echo -e "\n--- 4. Dodawanie artykułu ---"
# Teraz przekazujemy ID nowo utworzonej kategorii (pole "category")
CREATE_RESPONSE=$(curl -s -X POST "$BASE_URL/articles" \
    -H "Authorization: Bearer $TOKEN" \
    -H "Content-Type: application/json" \
    -d "{
       \"title\": \"[PL] Automatyczny wpis z kategorią\",
       \"content\": \"Treść wygenerowana przez skrypt z przypisaną kategorią.\",
       \"tags\": [\"test\", \"bash\"],
       \"category\": $CATEGORY_ID
     }")

ARTICLE_ID=$(echo $CREATE_RESPONSE | sed -n 's/.*"id":\([0-9]*\).*/\1/p')

if [ -z "$ARTICLE_ID" ]; then
    echo "Błąd tworzenia artykułu. Odpowiedź: $CREATE_RESPONSE"
    exit 1
fi
echo "Utworzono artykuł o ID: $ARTICLE_ID (w kategorii $CATEGORY_ID)"

echo -e "\n--- 5. Edycja artykułu (PUT) ---"
UPDATE_RESPONSE=$(curl -s -i -X PUT "$BASE_URL/articles/$ARTICLE_ID" \
    -H "Authorization: Bearer $TOKEN" \
    -H "Content-Type: application/json" \
    -d "{
       \"id\": $ARTICLE_ID,
       \"title\": \"[PL] Tytuł po edycji ze stałą kategorią\",
       \"content\": \"Zaktualizowana treść przez PUT.\",
       \"tags\": [\"test\", \"bash\", \"updated\"],
       \"category\": $CATEGORY_ID
     }")

echo "Odpowiedź serwera po edycji:"
echo "$UPDATE_RESPONSE"

echo -e "\nGotowe!"
