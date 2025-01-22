import { InitialModal } from "@/components/modals/initial-modal";
import { redirect } from "next/navigation";


// Khu vực kiểm tra Đã tồn tại nhóm chưa
const server = false;
let serverId:number = 0;

const SetupPage = () =>{
    if (server && serverId == 0){
        return redirect(`/servers/${serverId}}`)
    }
    return <InitialModal/>
}

export default SetupPage;