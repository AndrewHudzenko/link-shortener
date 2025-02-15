import {useState} from 'react'
import {Copy} from 'lucide-react';
import PropTypes from "prop-types"
import '../../styles/components/linkShortener/LinkShortenerForm.css'

export const LinkShortenerForm = ({onSubmit, isLoading, shortenedLink}) => {
    const [url, setUrl] = useState('')
    const [copied, setCopied] = useState(false);
    const [urlError, setUrlError] = useState('');

    const validateUrl = (value) => {
        try {
            new URL(value);
            return true;
        } catch {
            return false;
        }
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        setUrlError(''); // Сбрасываем ошибку при каждой попытке отправки

        if (validateUrl(url)) {
            onSubmit(url);
        } else {
            setUrlError('Пожалуйста, введите корректный URL (например: https://example.com)');
        }
    };

    const copyToClipboard = async () => {
        try {
            await navigator.clipboard.writeText(shortenedLink);
            setCopied(true);
            setTimeout(() => setCopied(false), 2000);
        } catch (err) {
            console.error('Failed to copy:', err);
        }
    };

    return (
        <div className="link-shortener__form-container">
            <form onSubmit={handleSubmit} className="link-shortener__form">
                <div className="link-shortener__form-group">
                    <label className="link-shortener__form-label">
                        Ваша ссылка
                    </label>
                    <div className="link-shortener__form-fields">
                        <input
                            type="text"
                            value={url}
                            onChange={(e) => setUrl(e.target.value)}
                            placeholder="https://example.com/very-long-url"
                            // required
                            className={`link-shortener__form-input ${urlError ? 'link-shortener__form-input--error' : ''}`}
                        />
                        {urlError && (
                            <div className="link-shortener__error-message">
                                {urlError}
                            </div>
                        )}

                        {shortenedLink && (

                            <div className="link-shortener__result-container">
                                <label className="link-shortener__form-label">
                                    Короткая ссылка
                                </label>
                                <div className="link-shortener__result-field">
                                    <div className="link-shortener__input-wrapper">
                                        <input
                                            type="text"
                                            value={shortenedLink}
                                            readOnly
                                            className="link-shortener__form-input link-shortener__form-input--short"
                                        />
                                        <button
                                            type="button"
                                            onClick={copyToClipboard}
                                            className={`link-shortener__copy-button ${copied ? 'link-shortener__copy-button--copied' : ''}`}
                                            title={copied ? 'Скопировано!' : 'Копировать'}
                                        >
                                            <Copy size={16}/>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        )}

                        <button
                            type="submit"
                            disabled={isLoading}
                            className="link-shortener__form-button"
                        >
                            {isLoading ? 'Сокращаем...' : 'Сократить'}
                        </button>
                    </div>
                </div>
            </form>
        </div>
    )
}

LinkShortenerForm.propTypes = {
    onSubmit: PropTypes.func.isRequired,
    isLoading: PropTypes.bool.isRequired,
    shortenedLink: PropTypes.string
}