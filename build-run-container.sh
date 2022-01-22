git clone https://github.com/Jprogramister/DemoEndpoint.git
docker build -t demon-endpoint .
docker run -d -p 8080:8080 demon-endpoint