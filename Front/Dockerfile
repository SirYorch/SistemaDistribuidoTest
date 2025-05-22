# Etapa 1: Build Angular
FROM node:18 AS builder
WORKDIR /app
COPY angular-distribuidos/ ./
RUN npm install
RUN npm run build --prod

# Etapa 2: Servir con Nginx
FROM nginx:alpine
COPY --from=builder /app/dist/angular-distribuidos/browser /usr/share/nginx/html
COPY angular-distribuidos/nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
