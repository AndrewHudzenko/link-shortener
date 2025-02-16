import {useState} from 'react';
import {LinkShortenerForm} from './LinkShortenerForm';
import '../../styles/components/linkShortener/LinkShortener.css';
import {Link2} from 'lucide-react';
import { API_URL } from '../../config';

export const LinkShortener = () => {
    const [shortenedLink, setShortenedLink] = useState(null);
    const [isLoading, setIsLoading] = useState(false);
    const [error, setError] = useState(null);

    const handleSubmit = async (url) => {
        setIsLoading(true);
        setError(null);

        try {
            const response = await fetch(`${API_URL}/shorten`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Access-Control-Allow-Origin': '*'
                },
                body: JSON.stringify({ url: url }) // Отправляем URL в теле запроса
            });

            if (response.status === 400) {
                throw new Error('Неверный формат ссылки');
            }
            if (response.status === 404) {
                throw new Error('Сервис недоступен');
            }
            if (!response.ok) {
                throw new Error('Ошибка сервера');
            }

            const data = await response.json();
            // Формируем полный URL для короткой ссылки
            const shortUrl = `http://localhost:8080/${data.shortCode}`;
            setShortenedLink(shortUrl);
        } catch (err) {
            setError('Произошла ошибка при сокращении ссылки: ' + err.message);
        } finally {
            setIsLoading(false);
        }
    };

    return (
        <div className="link-shortener">
            <div className="link-shortener__container">
                <Link2 className="link-shortener__icon"/>
                <h1 className="link-shortener__title">Сократите вашу ссылку</h1>
                <div className="link-shortener__description">
                    Введите длинную ссылку и получите её короткую версию
                </div>

                <LinkShortenerForm
                    onSubmit={handleSubmit}
                    isLoading={isLoading}
                    shortenedLink={shortenedLink}
                />

                {error && (
                    <div className="link-shortener__error">
                        {error}
                    </div>
                )}
            </div>
        </div>
    );
};