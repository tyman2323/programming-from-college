.386
.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword
;student: Ayman Tawaalai
;Class: CSC3210
;Assignment 2
;Description: This program will calculate a fixed expression layed out using registers, variables, and certain commands
.data
var1 word 134h
var2 word 139h
var3 word 67h
var4 word 47h
.code	
main proc
mov eax, 0
mov ebx, 0
mov ax, var3
add ax, var4
mov bx, var1
sub bx, var2
sub ax,bx
mov bx, 30
mov ecx,0
L1: 
	cmp cl, 3
	jge divis
	add bx, 30
	inc cl
	jmp l1
divis:
	mov cl, 0
divisio:;rounded to the nearest whole number
	cmp bx, 55
	jl combine
	sub bx, 55
	inc cl
	jmp divisio
combine:
	sub eax, ecx
mov edx, eax	
		

INVOKE ExitProcess,0
main ENDP
END main

