#!/bin/bash

respuesta=$(curl -s http://localhost:8081)

if [[ $? -eq 0 ]]; then
    echo "El servicio está funcionando correctamente."
    echo $respuesta
else
    echo "El servicio no está funcionando."
fi