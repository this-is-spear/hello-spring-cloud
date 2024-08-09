import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
    vus: 1,
    duration: '4m',
    rps: 10,
};

export default function () {
    const res = http.get('http://localhost:8080/hello/');

    check(res, {
        'status is 200': (r) => r.status === 200,
    });

    sleep(1 / options.rps);
}
