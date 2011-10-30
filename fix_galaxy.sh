#!/usr/bin/env bash

sed -i s/true/\"true\"/g $1
sed -i s/false/\"false\"/g $1
