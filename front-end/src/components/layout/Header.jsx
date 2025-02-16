import { Link2 } from 'lucide-react';
import '../../styles/components/layout/Header.css';

export const Header = () => {
    return (
        <header className="header">
            <div className="header__container">
                <div className="header__logo">
                    <a href="/link-shortener/" className="header__logo-link">
                        <Link2 href="/" className="header__logo-icon"/>
                    </a>
                    {/*<Link2 href="/" className="header__logo-icon"/>*/}
                    <a href="/link-shortener/" className="header__logo-text">URL Shortener</a>
                </div>
                <nav className="header__nav">
                    <ul className="header__nav-list">
                        <li className="header__nav-item">
                            <a href="/link-shortener/" className="header__nav-link">Главная</a>
                        </li>
                        <li className="header__nav-item">
                            <a href="/link-shortener/" className="header__nav-link">История</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </header>
    );
};