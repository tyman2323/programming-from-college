.386
.model flat, stdcall
.stack 4096
ExitProcess proto, dwExitCode:dword

.data


.code
main proc
	mov al, 01101111b
	and al, 00101101b
	mov al, 6Dh
	and al, 4Ah
	OR al, 61h
	mov al, 94h
	xor al, 37h

	
	INVOKE ExitProcess,0
main ENDP
END main


