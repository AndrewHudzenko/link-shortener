import { Link2 } from 'lucide-react';
import '../../styles/components/layout/Header.css';

export const Header = () => {
    return (
        <header className="header">
            <div className="header__container">
                <div className="header__logo">
                    <Link2 className="header__logo-icon" />
                    <span className="header__logo-text">URL Shortener</span>
                </div>
                <nav className="header__nav">
                    <ul className="header__nav-list">
                        <li className="header__nav-item">
                            <a href="/" className="header__nav-link">Главная</a>
                        </li>
                        <li className="header__nav-item">
                            <a href="/history" className="header__nav-link">История</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </header>
    );
};