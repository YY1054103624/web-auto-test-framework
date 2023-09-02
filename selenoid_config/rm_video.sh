#!/bin/bash
# shellcheck disable=SC2038
find /home/admin/selenoid/videos/ -name '*.mp4' | xargs rm -rf
