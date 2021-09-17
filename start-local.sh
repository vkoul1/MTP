
APPS="profile-svc quote-svc watchlist-svc mtp-app"
VERSION="0.0.1-SNAPSHOT"

/bin/rm -rf logs
/bin/mkdir -p logs

PIDS=""

for APP in $APPS ; do

    echo "Running $APP"
    java -jar ${APP}/build/libs/${APP}-${VERSION}.jar 2>&1 > logs/${APP}.log &

    PIDS="$PIDS $!"
done



function cleanup() {
    echo ""
    echo "Stopping java processes"
    echo "kill $PIDS"
    kill $PIDS
}

trap cleanup EXIT


# wait for logs to exist and tail them
sleep 3
tail -F logs/*

