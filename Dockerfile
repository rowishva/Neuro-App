FROM eclipse-temurin:17 as jre-build 
RUN $JAVA_HOME/bin/jlink \
--verbose \
--add-modules ALL-MODULE-PATH \
--strip-debug \
--no-man-pages \
--no-header-files \
--compress=2 \
--output /javaruntime 
FROM debian:buster-slim
ENV JAVA_HOME=/opt/java/openjdk
ENV PATH="${JAVA_HOME}/bin:${PATH}" 
COPY --from=jre-build /javaruntime ${JAVA_HOME}

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} finapp.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/neuroapp.jar"]