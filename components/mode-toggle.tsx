"use client";

import * as React from "react";
import { Moon, Sun } from "lucide-react"; // Sử dụng icon từ lucide-react
import { useTheme } from "next-themes";
import { IconButton, Menu, MenuItem } from "@mui/material";

export function ModeToggle() {
  const { theme, setTheme } = useTheme();  // Sử dụng 'theme' để kiểm tra trạng thái
  const [anchorEl, setAnchorEl] = React.useState<null | HTMLElement>(null);
  const open = Boolean(anchorEl);

  // Hàm mở menu
  const handleClick = (event: React.MouseEvent<HTMLElement>) => {
    setAnchorEl(event.currentTarget);
  };

  // Hàm đóng menu
  const handleClose = () => {
    setAnchorEl(null);
  };

  // Hàm để render icon theo theme hiện tại
  const renderIcon = () => {
    if (theme === "dark") {
      return <Moon className="h-[1.2rem] w-[1.2rem] rotate-0 scale-100 transition-all" />;
    } else if (theme === "light") {
      return <Sun className="h-[1.2rem] w-[1.2rem] rotate-0 scale-100 transition-all" />;
    } else {
      return (
        <span className="h-[1.2rem] w-[1.2rem] transition-all">
          <Sun className="absolute h-[1.2rem] w-[1.2rem] dark:scale-0" />
          <Moon className="absolute h-[1.2rem] w-[1.2rem] dark:scale-100" />
        </span>
      );
    }
  };

  return (
    <>
      {/* Nút chuyển chế độ */}
      <IconButton
        size="large"
        edge="end"
        color="inherit"
        onClick={handleClick}
        sx={{ position: "relative" }}
      >
        {renderIcon()} {/* Hiển thị icon theo theme */}
        <span className="sr-only">Toggle theme</span>
      </IconButton>

      {/* Menu lựa chọn chế độ */}
      <Menu
        anchorEl={anchorEl}
        open={open}
        onClose={handleClose}
        anchorOrigin={{ vertical: "top", horizontal: "right" }}
        transformOrigin={{ vertical: "top", horizontal: "right" }}
      >
        <MenuItem onClick={() => { setTheme("light"); handleClose(); }}>Light</MenuItem>
        <MenuItem onClick={() => { setTheme("dark"); handleClose(); }}>Dark</MenuItem>
        <MenuItem onClick={() => { setTheme("system"); handleClose(); }}>System</MenuItem>
      </Menu>
    </>
  );
}
