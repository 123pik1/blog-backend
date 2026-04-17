# Konfiguracja
API_URL="http://localhost:8080/api"
USERNAME="testuserxd"
PASSWORD="testpassword"

#echo "--- 1. Rejestracja użytkownika ---"
#curl -X POST "$API_URL/auth/register" \
#   -H "Content-Type: application/json" \
#  -d "{\"username\": \"$USERNAME\", \"password\": \"$PASSWORD\"}"
#echo -e "\n"

echo "--- 2. Logowanie i pobranie tokena ---"
# Wyciągamy token z JSONa za pomocą sed (zakładając, że wraca {"token":"..."})
TOKEN=$(curl -s -X POST "$API_URL/auth/login" \
    -H "Content-Type: application/json" \
    -d "{\"username\": \"$USERNAME\", \"password\": \"$PASSWORD\"}" | sed -E 's/.*"token":"([^"]+)".*/\1/')

if [ -z "$TOKEN" ]; then
    echo "Błąd: Nie udało się pobrać tokena!"
    exit 1
fi

echo "Pobrano token: ${TOKEN:0:10}..."
echo -e "\n"

echo "--- 3. Tworzenie sekcji (ADMIN) ---"
curl -X POST "$API_URL/sections" \
    -H "Authorization: Bearer $TOKEN" \
    -H "Content-Type: application/json" \
    -d '{"name": "Programowanie", "description": "Wszystko o kodzie"}'
echo -e "\n"

echo "--- 4. Tworzenie kategorii (ADMIN) ---"
curl -X POST "$API_URL/categories" \
    -H "Authorization: Bearer $TOKEN" \
    -H "Content-Type: application/json" \
    -d '{"name": "Java", "description": "Spring i okolice", "sectionId": 1}'
echo -e "\n"

echo "--- 5. Dodawanie artykułu (CAN_BLOG) ---"
curl -X POST "$API_URL/articles" \
    -H "Authorization: Bearer $TOKEN" \
    -H "Content-Type: application/json" \
    -d '{
           "title": "Mój pierwszy wpis",
           "content": "Treść artykułu o Springu",
           "categoryId": 1,
           "tags": ["spring", "java", "backend"]
         }'
echo -e "\n"

echo "--- 6. Pobieranie listy artykułów (PUBLIC) ---"
curl -X GET "$API_URL/articles/all"
echo -e "\n"
