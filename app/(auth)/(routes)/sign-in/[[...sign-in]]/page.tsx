import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';

const SignIn = () => {
    return (
        // <Box component="section" sx={{ p: 2, border: '1px dashed grey' }}>
        // </Box>
        <Box
            component="form"
            sx={{ '& > :not(style)': { m: 1, width: '25ch' } }}
            noValidate
            autoComplete="off"
        >
            <div>
                Giao diện "<b>Login</b>" sẽ bỏ vào đây
            </div>
            <TextField id="outlined-basic" label="Outlined" variant="outlined" />
        </Box>
    );
}

export default SignIn;
