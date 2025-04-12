#!/bin/bash

set -e

BACKEND_DIR=${1:-"../backend"}
DB_DIR=${2:-"../database"}

BACKEND_IMAGE="manuelagb/movies-api:latest"
DB_IMAGE="manuelagb/movies-db:latest"

echo "📦 Building backend image from: $BACKEND_DIR..."
docker build -t $BACKEND_IMAGE $BACKEND_DIR/ || {
  echo "❌ Backend build failed!"
  exit 1
}

echo "⬆️ Pushing backend image to Docker Hub..."
docker push $BACKEND_IMAGE || {
  echo "❌ Backend push failed!"
  exit 1
}

echo "📦 Building db image from: $DB_DIR..."
docker build -t $DB_IMAGE $DB_DIR/ || {
  echo "❌ database build failed!"
  exit 1
}

echo "⬆️ Pushing db image to Docker Hub..."
docker push $DB_IMAGE || {
  echo "❌ database push failed!"
  exit 1
}

echo "🚀 Starting containers..."
docker compose up -d --build || {
  echo "❌ Failed to start containers!"
  exit 1
}

echo "✅ Deployment completed successfully!"