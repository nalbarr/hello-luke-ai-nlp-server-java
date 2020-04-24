#!/bin/bash

# set default ENV vars

export PROJECT=nla-cs125

gcloud config set project ${PROJECT}

export ZONE=us-central1-c
gcloud config set compute/zone ${ZONE}