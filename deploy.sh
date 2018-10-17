#!/bin/bash

case "${1}" in
tag)
  version="${TRAVIS_TAG}"
  echo "Uploading artifacts with version ${version}"
  ./gradlew bintrayUpload -Pversion="${version}"
  ;;
dev)
  tag=$(git describe --tags $(git rev-list --tags --max-count=1))
  version="${tag}-dev-b${TRAVIS_BUILD_NUMBER}"
  echo "Uploading artifacts with version ${version}"
  ./gradlew bintrayUpload -Pversion="${version}"
  ;;
*)
  echo "Call script with tag or dev argument"
  ;;
esac
