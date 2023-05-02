.386
.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword
;student: Ayman Tawaalai
;Class: CSC3210
;Assignment 2
;Description: This program will calculate a fixed expression layed out using registers, variables, and certain commands
.data
val1 word 12
val2 dword 9 
val3 byte 2 
val4 byte 20
.code	
main proc
mov eax,0
movzx ax, val3
sub ax, val1
neg ax
movzx ebx, val4
neg ebx
add ebx, val2
mov ecx, ebx
add ecx, eax
add ecx, 3
INVOKE ExitProcess,0
main ENDP
END main

