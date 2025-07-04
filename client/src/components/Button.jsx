// src/components/Button.jsx
import { useState } from 'react'
import axios from 'axios'

const Button = () => {
	const [response, setResponse] = useState('')
	const VITE_SERVER_URL = import.meta.env.VITE_SERVER_URL

	const handleClick = async () => {
		try {
			const res = await axios.get(`${VITE_SERVER_URL}/health`)
			setResponse(res.data)
		} catch (error) {
			console.error('Error fetching health:', error)
			setResponse('Error fetching health status')
		}
	}

	return (
		<div className='mx-auto container'>
			<button className='border p-2 border-red-800 text-red-500' onClick={handleClick}>Check Server Health</button>
			{response && <p>{response}</p>}
		</div>
	)
}

export default Button
