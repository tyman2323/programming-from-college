.386
.model flat, stdcall
.stack 4096
ExitProcess proto, dwExitCode:dword

.data
byteval sbyte 1,2,3,-7h
wordval word 1000h, 2000h, 3000h, 4000h
dwordval dword 34567890h, 90785634h, 12346745h 
array dword 4 dup(0)

.code
main proc
mov eax, 0
mov ebx, 0
mov ecx, 0
mov al, 10000000b
shr al, 1
	INVOKE ExitProcess,0
main ENDP
END main


