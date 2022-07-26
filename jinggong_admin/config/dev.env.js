'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',
  BASE_API: '"http://8.131.54.86:9110"',
  OSS_PATH: '"https://bit-jinggong-file.oss-cn-beijing.aliyuncs.com"'
})
