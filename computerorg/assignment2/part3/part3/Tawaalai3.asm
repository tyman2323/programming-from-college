.386
.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword
;student: Ayman Tawaalai
;Class: CSC3210
;Assignment 3
;Description: Conduct math operations with an array
.data
z dword 3 Dup(?)
x dword 10
y dword 15
r dword 4
.code	
main proc
mov eax, x
add eax, y
add eax, r
mov z[0], eax
mov eax, y
sub eax, r
add eax, z[0]
mov [z+4], eax
mov eax, z[4]
add eax, y
add eax, z[0]
mov [z+8], eax
INVOKE ExitProcess,0
main ENDP
END main

