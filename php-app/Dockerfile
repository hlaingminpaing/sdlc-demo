# ---- PHP + Apache ----
FROM php:8-apache

# Set working directory
WORKDIR /var/www/html

# Install mysqli extension (needed for MySQL)
RUN docker-php-ext-install mysqli && docker-php-ext-enable mysqli

# Copy app files
COPY . .

# Expose default HTTP port
EXPOSE 80

