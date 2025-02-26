# Use the official Postgres image as a base
FROM postgres:latest

# Optionally, add custom configuration files or initialization scripts
# For example, copying an init script to the container
COPY init.sql /docker-entrypoint-initdb.d/

# Set environment variables (or you can pass these during container run)
ENV POSTGRES_USER=mygas
ENV POSTGRES_PASSWORD=mygas
ENV POSTGRES_DB=mygas

EXPOSE 5432