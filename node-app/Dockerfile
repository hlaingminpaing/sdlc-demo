# ---- Node.js App ----
FROM node:20-alpine

# Set working directory
WORKDIR /app

# Copy dependency files first (better cache usage)
COPY package*.json ./

# Install only production dependencies
RUN npm install --production

# Copy the rest of the app
COPY . .

# Expose port
EXPOSE 3000

# Start app
CMD ["npm", "start"]

