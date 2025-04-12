#!/bin/bash

hacer_solicitud() {
    local metodo=$1
    local url=$2
    local datos=$3

    respuesta=$(curl -s -X  "$metodo" -H "Content-Type: application/json" -d "$datos" "http://localhost:8080/api/$url")
    if [[ $? -eq 0 ]]; then
        echo "El servicio está funcionando correctamente."
        echo $respuesta
    else
        echo "El servicio no está funcionando."
    fi                                                  
}

# hacer_solicitud "GET" "movies" ""
# echo

hacer_solicitud "GET" "movies/1" ""
echo

# hacer_solicitud "POST" "movies" '
#     {"name": "Shrek", "genre": "Comedia", "duration": 2010}'
# echo

# hacer_solicitud "PUT" "movies/4" '
#     {"name": "Shrek", "genre": "Animada", "duration": 120 }'
# echo

# hacer_solicitud "DELETE" "movies/4" ""
