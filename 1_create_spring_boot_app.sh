#!/bin/bash

curl https://start.spring.io/starter.tgz \
  -d bootVersion=2.1.8.RELEASE \
  -d dependencies=web \
  -d baseDir=gae-standard-example | tar -xzvf -

cd gae-standard-example
mv src ..
mv test ..
mv mv* ..
# rmdir gae-standard-example