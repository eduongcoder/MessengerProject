import { redirect } from "next/dist/server/api-utils";

export const NavigationSidebar = () => {
    const profile = "You Have an object here";
    
    if (!profile){
        return redirect("/");
    }
    
    return (  
        <div>
            Navgiagtion
        </div>
    );
}
 