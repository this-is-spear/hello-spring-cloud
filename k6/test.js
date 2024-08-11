import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
    vus: 1,
    duration: '6m',
    rps: 10,
};

export default function () {
    const res1 = http.get('http://localhost:8080/hello/');
    const res2 = http.get('http://localhost:8081/hello/');

    check(res1, {
        'status is 200': (r) => r.status === 200,
    });

    check(res2, {
        'status is 200': (r) => r.status === 200,
    });

    sleep(1 / options.rps);
}
