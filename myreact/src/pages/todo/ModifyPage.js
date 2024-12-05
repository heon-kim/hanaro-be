import {useParams} from "react-router-dom";
import ModifyComponent from "../../components/todo/ModifyComponent";

const ModifyPage=()=>{
    const {tno} = useParams()
    return (
        <div className="font-extrabold w-full bg-white mt-6">
            <div className="text-3xl font-extrabold">
                Todo Modify Page Component {tno}
                <ModifyComponent tno={tno}></ModifyComponent>
            </div>
        </div>
    )
}

export default ModifyPage