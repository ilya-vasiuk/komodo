#!/bin/bash

case "${1}" in
tag)
  version="${TRAVIS_TAG}"
  echo "Uploading artifacts with version ${version}"
  ./gradlew bintrayUpload -Pversion="${version}"
  ;;
dev)
  version="$(git describe --abbrev=0 --tags)-dev-b${TRAVIS_BUILD_NUMBER}"
  echo "Uploading artifacts with version ${version}"
  ./gradlew bintrayUpload -Pversion="${version}"
  ;;
*)
  echo "Call script with tag or dev argument"
  ;;
esac
