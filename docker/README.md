# Prometheus and Grafana Docker example

A simple setup to run Prometheus and Grafana in Docker and scrape the metrics provided by spring-actuator


To run the container:

- Install [Docker](https://www.docker.com/get-started)
- Run `docker-compose up -d`
- Login to Grafana at [https://localhost:3000](https://localhost:3000) username/password = admin/admin
- Grafana requires you to change the password
- Click the "+" icon, then "import"
- Enter 9568 in the id field to import an example dashboard for spring-actuator metrics, and hit tab
- Under Options -> Prometheus select the Prometheus data source
- Click "Import"
- Explore!

- Run `docker-compose down` to stop docker


##### Notes:

This config doesn't save state between runs, so you'll have to redo the import step each time.


I pulled this config from [here](https://www.microfocus.com/documentation/host-access-for-the-cloud/2-4-2/user-guide/using-prometheus-grafana.html) if you're interested in the details.
