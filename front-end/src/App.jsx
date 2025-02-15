import './styles/App.css'
import {MainLayout} from "./components/layout/MainLayout.jsx"
import {LinkShortener} from "./components/linkShortener/LinkShortener.jsx"

function App() {
    return (
        <MainLayout>
            <LinkShortener/>
        </MainLayout>
    )
}

export default App
