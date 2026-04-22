#!/usr/bin/env bash
set -e

APP="target/GoldRush/bin/GoldRush"

if [ ! -f "$APP" ]; then
  echo "Runtime image not found. Building project first..."
  ./package.sh
fi

"$APP"