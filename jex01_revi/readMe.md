Java Config
 └ Servlet 3.0, Tomcat 7.0이 나오면서 제공.
 
 
JavaConfig 사용시 주의사항
 - spring 3.1 버전 이상 필요
 - spring 3.1.x 버전은 cglib dependency도 추가해야함
 - spring 3.2.x 버전 이상부터는 cglib이 내부에 포함되므로 dependency 추가할 필요 없음
 - servlet-api 3.0 버전 이상 필요 (web.xml을 없애기 위해)
 - maven-war-plugin의 failOnMissingWebXml=false로 설정 (web.xml 파일이 없을시 에러 발생을 없애기 위해 필요하다는데 해당 설정 없이 해도 잘되는듯)
