#!/bin/bash
# shellcheck disable=SC2038
find /home/admin/selenoid/logs/ -name '*.log' | xargs rm -rf
