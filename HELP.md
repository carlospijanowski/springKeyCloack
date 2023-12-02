# PROJETO WEB KEY CLOACK

referencia
https://www.youtube.com/watch?v=wgdo5I53GQo

##
- sring web
- spring security
- docker

## STEPS DO ENTENDIMENTO
- subir docker com o keycloack

KEYCLOAK
- crie um healm
- crie um client
- crie os users
- crie as realms roles

OBS.: em realm settings tem um endpoint exposto para buscar o token
    modelo cURL <br>
        `curl --location 'http://localhost:8080/realms/youtube/protocol/openid-connect/token' \
        --header 'Content-Type: application/x-www-form-urlencoded' \
        --header 'Cookie: JSESSIONID=963A3E29552F5124C4F424A2D1D9CD13' \
        --data-urlencode 'client_id=app_youtube' \
        --data-urlencode 'username=user_youtube' \
        --data-urlencode 'password=user' \
        --data-urlencode 'grant_type=password'`
<br>
<br>