"use client";
import * as React from 'react';
import { Box, Button, Dialog, DialogActions, DialogContent, DialogContentText, DialogTitle, IconButton, TextField, Typography, FormControl,} from "@mui/material";
import CloseIcon from "@mui/icons-material/Close";
import { useState, FormEvent } from "react";
import { FileUpload } from '@/components/file-upload';

export const InitialModal = () => {
    const [open, openchange] = useState(false);
    const functionopenpopup = () => {
        openchange(true);
    };
    const closepopup = () => {
        openchange(false);
    };
    const [formData, setFormData] = useState({
        name: '', email: '', password: '', 
        gender: '', termsAccepted: false,
    });

    const handleSubmit = (event: FormEvent<HTMLFormElement>): void => {
        event.preventDefault();
        const formData = new FormData(event.currentTarget);
        console.log(Object.fromEntries(formData.entries())); // Handle form data
    };

    const handleFileChange = (url?: string) => {
        console.log('File URL:', url);
    };

    return (
        <div style={{ textAlign: 'center' }}>
            <h1>MUI - DIALOG</h1>
            <Dialog open={true} onClose={closepopup}>
                <DialogContent className="pt-8 px-6">
                    <IconButton onClick={closepopup} style={{ float: 'right', alignItems: 'center' }}>
                        <CloseIcon color="primary" />
                    </IconButton>
                    <DialogTitle className="text-2xl text-center font-bold">
                        Customize your server
                    </DialogTitle>
                    <DialogContentText className="text-center text-zinc-500">
                        Give your server a personality with a name and an image, You can always change it later.
                    </DialogContentText>
                

                <form className="mt-2 space-y-8" onSubmit={handleSubmit}>   
                    <div className="space-y-8">
                        <div className="flex items-center justify-center text-center">
                            <FormControl>
                                <FileUpload
                                // endpoint="serverImage" value={""} onChange={handleFileChange}
                                />
                            </FormControl>
                        </div>

                        <div>
                            <Box>
                                <Typography>User Registration</Typography>
                                <TextField
                                    size="medium"
                                    label="Server name"
                                    name="name"
                                    value={formData.name}
                                    onChange={(e) => setFormData({ ...formData, name: e.target.value })}
                                    className="bg-zinc-300/50 border-0 focus-visible:ring-0 text-black focus-visible:ring-offset-0"
                                    fullWidth
                                    required
                                    placeholder="Enter the server name"
                                />
                            </Box>
                        </div>
                    </div>
                </form>
                </DialogContent>
                <DialogActions className="mt-3 bg-gray-100 w-auto px-6 py-4">
                    <Button
                        sx={{ width: "100%" }}
                        size="large"
                        type="submit"
                        variant="contained"
                        className="bg-indigo-500 text-white hover:bg-indigo-500/90"
                    >
                        Create
                    </Button>
                </DialogActions>


            </Dialog>
        </div>
    );
};
