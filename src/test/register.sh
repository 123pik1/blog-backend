# Konfiguracja
API_URL="http://localhost:8080/api"
USERNAME="testuserxd"
PASSWORD="testpassword"

echo "--- 1. Rejestracja użytkownika ---"
curl -X POST "$API_URL/auth/register" \
    -H "Content-Type: application/json" \
    -d "{\"username\": \"$USERNAME\", \"password\": \"$PASSWORD\"}"
echo -e "\n"
