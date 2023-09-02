#!/bin/bash
# shellcheck disable=SC2002
cat browsers.json | jq -r '..|.image?|strings' | xargs -I{} docker pull {}
