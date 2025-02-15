import {Header} from "./Header.jsx"
import {Footer} from "./Footer.jsx"
import PropTypes from "prop-types"

export const MainLayout = ({children}) => {
    return (
        <div>
            <Header/>
            <main>
                {children}
            </main>
            <Footer/>
        </div>
    )
}

MainLayout.propTypes = {
    children: PropTypes.node.isRequired
}
