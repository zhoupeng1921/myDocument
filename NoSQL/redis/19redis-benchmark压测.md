1. redis-benchmark -h ip -p port -c 100 -n 100000 100个并发连接，100000个请求
2. redis-benchmark -h ip -p port -q -d 100 存取大小为100字节的数据包  -q quiet输出日志少些
3. redis-benchmark -t set,lpush -q -n 100000   只测试set和lpush命令
4. redis-benchmark -n 100000 -q script load "redis.call('set','foo','bar')" 只测试某些数值存取

