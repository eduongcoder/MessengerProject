import React, { ReactNode } from 'react';
import Button from '@mui/material/Button';

interface Props {
  children: ReactNode;
}

export default function DisableElevation({ children }: Props) {
  return (
    <Button
      sx={{ backgroundColor: "black" }}
      variant="contained"
      disableElevation
    > 
      {children}
    </Button>
  );
}