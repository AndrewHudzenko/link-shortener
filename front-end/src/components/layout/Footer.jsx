import '../../styles/components/layout/Footer.css';

export const Footer = () => {
    const currentYear = new Date().getFullYear();

    return (
        <footer className="footer">
            <div className="footer__container">
                <div className="footer__content">
                    <div className="footer__copyright">
                        © {currentYear} URL Shortener. All rights reserved.
                    </div>
                    <div className="footer__links">
                        <a href="/privacy" className="footer__link">
                            Privacy Policy
                        </a>
                        <a href="/terms" className="footer__link">
                            Terms of Service
                        </a>
                        <a href="/contact" className="footer__link">
                            Contact
                        </a>
                    </div>
                </div>
            </div>
        </footer>
    );
};