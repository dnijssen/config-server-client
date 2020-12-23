# Steps to reproduce

1. Startup the Config Server (runs on port 8888)
2. Startup the Config Client (runs on port 8080) with profile: `test` (e.g. by adding VM option `-Dspring.profiles.active=test`)
3. Expected result is a system print line with; **Test**
4. Actual result is a system print line with; **Default**