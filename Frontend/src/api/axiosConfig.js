
import axios from 'axios';


export default axios.create({
    baseURL: import.meta.env.VITE_DEV_URL,
    // headers: {"ngrok-skip-browser-warning": "true"}
});