import {FileCode, Github, Linkedin} from 'lucide-react';
import '../../styles/components/linkShortener/About.css';

export const About = () => {
    return (
        <div className="about">
            <div className="about__container">
                <h2 className="about__title">О проекте</h2>
                <div className="about__content">
                    <p className="about__description">
                        URL Shortener - приложение для сокращения ссылок,
                        разработанное с использованием Groovy и React от
                         <a
                            href={"https://www.linkedin.com/in/andrew-hudzenko-8942b3251/"}
                            target="_blank"
                            rel="noopener noreferrer"
                            className="about__author"
                        >
                             Andrew Hudzenko
                        </a>
                    </p>

                    <div className="about__links">
                        <a
                            href="https://github.com/andrewhudzenko"
                            target="_blank"
                            rel="noopener noreferrer"
                            className="about__link"
                        >
                            <Github size={20}/>
                            <span>GitHub</span>
                        </a>

                        <a
                            href="https://github.com/andrewhudzenko/link-shortener"
                            target="_blank"
                            rel="noopener noreferrer"
                            className="about__link"
                        >
                            <FileCode size={20}/>
                            <span>Репозиторий проекта</span>
                        </a>

                        <a
                            href="https://www.linkedin.com/in/andrew-hudzenko-8942b3251/"
                            target="_blank"
                            rel="noopener noreferrer"
                            className="about__link"
                        >
                            <Linkedin size={20}/>
                            <span>LinkedIn</span>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    );
}