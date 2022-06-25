1.Account
###1. Root User
1. email access
###2. IAM User
1. Identity and Access Management user
2. day-to-day activity
3. Authorize permission to specific user
4. Assign the permission to groups
   1. Create new group
   2. assign policies(eg. AdministratorAccess)
5. Create User
   1. set name of user
   2. set AWS access type(credential type)
      1. console access
      2. programmatic access
   3. make password
   4. assign user to existing group

#2. Concept
1. Cloud 
   1. On-demand resource provisioning
    > if you need, you can get it anytime you want
2. ElasticBeanStalk
   1. so many solutions (90s) in aws, and let beanstalk choose what to use.
   2. helps us to deploy, monitor, scale an application
   3. Environment Tier
      1. Web server environment
      2. Worker environment: (eg.Batch) application that processes long running workloads on demand or performs tasks on a schedule
   4. platform
      1. JAR - Java
      2. WAR - Tomcat
   5. Additional configuration
      1. Instance: no of CPU 
         1. t2.micro에서 딱히 바꾸지 말자
      2. Capacity: control one or more than 2 instances
      3. Load balancer: when there is multiple instances, you can load balance it
      4. Rolling update and deployments: how you update and deploy when you update next version
      5. Security
      6. Monitor
      7. Database
   6. application setting
      1. AWS Elastic Beanstalk assumes that the application will listen on port 5000.
3. Background Knowledge
   1. EC2(Elastic Compute Cloud)
      1. charge based on how long does it run
   2. Elastic IP address
      1. normally every time I build and deploy, elastic IP provides static IP address
      2. if you do not assign elstatic IP address, it charge you.
4. CostManagement
   1. 처음 첫주간 빌링대시보드 계속 봐라
   2. 빌링얼럴트를 켜라
   3. 안쓰는 리소스는 멈춰라
   (인스턴스) 기간에 따라
   (스토리지) 사용에 따라
   4. Cloud Watch 사용
   5. AWS Budget세팅 - 아직 안끝남
5. Application LifeCycle
   1. Test on local machine
   2. Build the artifact(JAR, WAR)
   3. Deploy to AWS
