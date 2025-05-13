# Etapa 1: construir Angular
FROM node:18 as builder
WORKDIR /app
COPY angular-distribuidos/ ./
RUN npm install
RUN npm run build

# Etapa 2: servir con Nginx
FROM nginx:alpine
COPY --from=builder /app/dist/angular-distribuidos/browser /usr/share/nginx/html
COPY angular-distribuidos/nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
