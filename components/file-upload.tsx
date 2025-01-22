// "use client";

// import * as React from 'react';
// import { styled } from '@mui/material/styles';
// import Button from '@mui/material/Button';
// import CloudUploadIcon from '@mui/icons-material/CloudUpload';

// // interface FileUploadProps {
// //     onChange: (url?: string) => void;
// //     value: string;
// //     endpoint: "messageFile" | "serverImage"
// // }

// export const FileUpload = (
//     // { onChange, value, endpoint }: FileUploadProps
// ) => {

//     const VisuallyHiddenInput = styled('input')({
//         clip: 'rect(0 0 0 0)', clipPath: 'inset(50%)',
//         height: 1, overflow: 'hidden', position: 'absolute',
//         bottom: 0, left: 0, whiteSpace: 'nowrap', width: 1,
//     });

//     return (
//         // <div>File upload component</div>
//         <Button
//             className="bg-indigo-500 text-white hover:bg-indigo-500/90"
//             component="label"
//             role={undefined} variant="contained" tabIndex={-1}
//             startIcon={<CloudUploadIcon />}
//         >
//             Upload files
//             <VisuallyHiddenInput
//                 type="file" // multiple
//                 onChange={(event) => console.log(event.target.files)}
//             />
//         </Button>
//     );
// }
"use client";

import * as React from 'react';
import { styled } from '@mui/material/styles';
import Button from '@mui/material/Button';
import CloudUploadIcon from '@mui/icons-material/CloudUpload';
import { X } from 'lucide-react';

export const FileUpload = () => {
    const [selectedImage, setSelectedImage] = React.useState<string | null>(null);

    const VisuallyHiddenInput = styled('input')({
        clip: 'rect(0 0 0 0)',
        clipPath: 'inset(50%)',
        height: 1,
        overflow: 'hidden',
        position: 'absolute',
        bottom: 0,
        left: 0,
        whiteSpace: 'nowrap',
        width: 1,
    });

    const handleFileChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        const file = event.target.files?.[0];
        if (file) {
            const imageUrl = URL.createObjectURL(file);
            setSelectedImage(imageUrl);
        }
    };

    return (
        <div style={{ textAlign: 'center' }}>
            {selectedImage ? (


                <div className="h-20 w-20 relative overflow-hidden bg-transparent">
                    <img
                        src={selectedImage} alt="Selected File"
                        className="rounded-full h-full w-full object-cover"
                    />
                    <button
                        className="bg-rose-500 text-white p-1 rounded-full absolute top-0 right-0 shadow-sm"
                        onClick={() => setSelectedImage(null)}
                    >
                        <X className="h-4 w-4" />
                    </button>
                </div>



            ) : (
                <Button
                    className="bg-indigo-500 text-white hover:bg-indigo-500/90"
                    component="label"
                    role={undefined}
                    variant="contained"
                    tabIndex={-1}
                    startIcon={<CloudUploadIcon />}
                >
                    Upload files
                    <VisuallyHiddenInput
                        type="file"
                        onChange={handleFileChange}
                    />
                </Button>
            )}
        </div>
    );
};
